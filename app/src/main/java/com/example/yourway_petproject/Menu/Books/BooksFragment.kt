package com.example.yourway_petproject.Menu.Books

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yourway_petproject.Models.CleanArchitectureBlueprintsApp
import com.example.yourway_petproject.Adapters.BookAdapter
import com.example.yourway_petproject.LayoutUtils
import com.example.yourway_petproject.Models.BookWithStatus
import com.example.yourway_petproject.R
import com.example.yourway_petproject.databinding.BooksFragmentBinding


class BooksFragment : Fragment() {
    private lateinit var booksAdapter: BookAdapter

    private var _binding: BooksFragmentBinding? = null
    private val binding get() = _binding!!

    private val booksViewModel: BooksViewModel by viewModels {
        Log.i("KEK", requireActivity().application.toString())
        BooksViewModel.BooksViewModelFactory(
            ((requireActivity().application) as CleanArchitectureBlueprintsApp).getBookUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApp).getBookmarksUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApp).bookmarkBooksUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApp).unbookmarkBookUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApp).bookWithStatusMapper,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        booksAdapter = BookAdapter(requireContext(), object : BookAdapter.ActionClickListener {
            override fun bookmark(book: BookWithStatus) {
                booksViewModel.bookmark(book)
            }

            override fun unbookmark(book: BookWithStatus) {
                booksViewModel.unbookmark(book)
            }
        })

        booksViewModel.getBooks("Robert C. Martin")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.books_fragment, container, false)
        _binding = BooksFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        booksViewModel.books.observe(viewLifecycleOwner, {
            booksAdapter.submitUpdate(it)
        })

        booksViewModel.dataLoading.observe(viewLifecycleOwner, { loading ->
            when (loading) {
                true -> LayoutUtils.crossFade( binding.pbLoading, binding.rvBooks)
                false -> LayoutUtils.crossFade(binding.rvBooks, binding.pbLoading)
            }
        })

        binding.rvBooks.apply {
            layoutManager =
                GridLayoutManager(requireContext(), COLUMNS_COUNT)
            adapter = booksAdapter
        }

        booksViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(
                requireContext(),
                getString(R.string.anErrorHasOccurred, it),
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    companion object {
        const val COLUMNS_COUNT = 2
    }
}
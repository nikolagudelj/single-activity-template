package com.nikola.singleactivitytemplate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nikola.singleactivitytemplate.viewmodel.MyViewModel
import androidx.navigation.fragment.findNavController

/** Base fragment class for fragments which use the [MyViewModel] */
abstract class BaseFragment : Fragment() {
    abstract  var layoutId : Int    // Redefine for each separate fragment
    protected lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    /** Loads the ViewModel field */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            goBack()
        }
    }

    /** Returns to the previous fragment, or closes the app if no fragments are on the
     * back stack. */
    protected open fun goBack() {
        if(!findNavController().popBackStack())
            requireActivity().finish()  // Close app if there are no fragments on the back stack
    }
}
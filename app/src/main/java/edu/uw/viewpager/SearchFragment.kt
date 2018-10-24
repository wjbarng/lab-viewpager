package edu.uw.viewpager


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private var callback: OnSearchListener? = null

    internal interface OnSearchListener {
        fun onSearchSubmitted(searchTerm: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            callback = context as OnSearchListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString() + " must implement OnSearchListener")
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_search, container, false)

        val searchButton = rootView.findViewById<Button>(R.id.btn_search)
        searchButton.setOnClickListener {
            val text = rootView.findViewById<View>(R.id.txt_search) as EditText
            val searchTerm = text.text.toString()
            callback!!.onSearchSubmitted(searchTerm)
        }

        return rootView
    }

    companion object {

        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor

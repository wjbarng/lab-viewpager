package edu.uw.viewpager


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.movie_detail, container, false)

        val args = arguments
        if (args != null) {
            val movie = args.getParcelable<Movie>(MOVIE_PARCEL_KEY)
            val titleView = rootView.findViewById<View>(R.id.txt_movie_title) as TextView
            titleView.text = movie!!.toString()

            val urlView = rootView.findViewById<View>(R.id.txt_movie_url) as TextView
            urlView.text = movie.url

            val descView = rootView.findViewById<View>(R.id.txt_movie_description) as TextView
            descView.text = movie.description
        }

        return rootView
    }

    companion object {

        val MOVIE_PARCEL_KEY = "movie_parcel"

        fun newInstance(movie: Movie): DetailFragment {

            val args = Bundle()
            args.putParcelable(MOVIE_PARCEL_KEY, movie)
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor

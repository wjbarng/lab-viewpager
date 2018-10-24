package edu.uw.viewpager

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A class that represents information about a movie.
 */

@Parcelize
class Movie(
        var title: String,
        var year: String,
        var description: String,
        var url: String
) : Parcelable {

    init {
        year = year.substring(0, 4) //handle year from string
    }

    override fun toString(): String {
        return this.title + " (" + this.year + ")"
    }

//    protected constructor(`in`: Parcel) : this(
//            title = `in`.readString(),
//            year = `in`.readString(),
//            description = `in`.readString(),
//            url = `in`.readString()
//        )
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeString(title)
//        dest.writeString(year)
//        dest.writeString(description)
//        dest.writeString(url)
//    }
//
//    companion object {
//
//        @JvmField
//        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
//            override fun createFromParcel(`in`: Parcel): Movie {
//                return Movie(`in`)
//            }
//
//            override fun newArray(size: Int): Array<Movie?> {
//                return arrayOfNulls<Movie>(size)
//            }
//        }
//    }
}

package com.example.firstapps.intent_and_data_passing

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Student( val name : String) :Serializable{   }



class StudentParcelable(val name : String) : Parcelable{
    constructor(parcel: Parcel) : this(parcel.readString().toString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentParcelable> {
        override fun createFromParcel(parcel: Parcel): StudentParcelable {
            return StudentParcelable(parcel)
        }

        override fun newArray(size: Int): Array<StudentParcelable?> {
            return arrayOfNulls(size)
        }
    }

}
package com.example.adrian.myapplication2

import android.os.Parcel
import android.os.Parcelable

class NoteInfo(var course: CourseInfo,
               var title: String,
               var text: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readParcelable(CourseInfo::class.java.classLoader),
            parcel.readString(),
            parcel.readString()) {
    }

    fun getCompareKey(): String {
        return course.courseId + "|" + title + "|" + text
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as NoteInfo?

        return getCompareKey() == that!!.getCompareKey()
    }

    override fun hashCode(): Int {
        return getCompareKey().hashCode()
    }

    override fun toString(): String {
        return getCompareKey()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedObject(course, 0)
        parcel.writeString(title)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<NoteInfo> {
            override fun createFromParcel(parcel: Parcel): NoteInfo {
                return NoteInfo(parcel)
            }

            override fun newArray(size: Int): Array<NoteInfo?> {
                return arrayOfNulls(size)
            }
        }
    }


}
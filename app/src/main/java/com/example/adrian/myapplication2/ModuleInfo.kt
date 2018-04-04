package com.example.adrian.myapplication2

import android.os.Parcel
import android.os.Parcelable

class ModuleInfo(var moduleId: String,
                 var title: String,
                 var isComplete: Boolean = false) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun toString(): String {
        return title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as ModuleInfo?

        return moduleId == that!!.moduleId
    }

    override fun hashCode(): Int {
        return moduleId.hashCode()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(moduleId)
        parcel.writeString(title)
        parcel.writeByte(if (isComplete) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<ModuleInfo> {
            override fun createFromParcel(parcel: Parcel): ModuleInfo {
                return ModuleInfo(parcel)
            }

            override fun newArray(size: Int): Array<ModuleInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
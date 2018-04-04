package com.example.adrian.myapplication2

import android.os.Parcel
import android.os.Parcelable

class CourseInfo(var courseId: String,
                 var title: String,
                 var modules: List<ModuleInfo>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            ArrayList()) {
        parcel.readTypedList(ArrayList<ModuleInfo>(), ModuleInfo.CREATOR)
    }

    fun parcelRico(): ArrayList<ModuleInfo> {
        return ArrayList<ModuleInfo>()
    }

    fun getModulesCompletionStatus(): BooleanArray {
        val status = BooleanArray(modules.size)

        modules.forEachIndexed { index, moduleInfo ->
            status[index] = moduleInfo.isComplete
        }

        return status
    }

    fun setModulesCompletionStatus(status: BooleanArray): Unit {
        modules.forEachIndexed { index, moduleInfo ->
            moduleInfo.isComplete = status[index]
        }
    }

    fun getModuleByModuleId(moduleId: String): ModuleInfo? {
        return modules.find { moduleInfo -> moduleInfo.moduleId == moduleId }
    }

    override fun toString(): String {
        return title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val that = other as CourseInfo?
        return courseId == that!!.courseId
    }

    override fun hashCode(): Int {
        return courseId.hashCode()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(courseId)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CourseInfo> {
            override fun createFromParcel(parcel: Parcel): CourseInfo {
                return CourseInfo(parcel)
            }

            override fun newArray(size: Int): Array<CourseInfo?> {
                return arrayOfNulls(size)
            }
        }
    }

}
package com.example.adrian.myapplication2

class NoteInfo(var course: CourseInfo,
               var title: String,
               var text: String) {

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
}
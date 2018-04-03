package com.example.adrian.myapplication2

class ModuleInfo(var moduleId: String,
                 var title: String,
                 var isComplete: Boolean = false) {

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
}
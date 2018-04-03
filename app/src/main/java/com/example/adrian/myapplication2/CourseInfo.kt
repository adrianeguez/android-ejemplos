package com.example.adrian.myapplication2

class CourseInfo(var courseId: String,
                 var title: String,
                 var modules: List<ModuleInfo>) {

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

}
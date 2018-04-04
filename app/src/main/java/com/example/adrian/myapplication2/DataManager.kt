package com.example.adrian.myapplication2

import java.util.ArrayList
class DataManager{
    companion object Factory {
        var courses: ArrayList<CourseInfo> = ArrayList()
        var notes: ArrayList<NoteInfo> = ArrayList()

        init {
            initializeCourses()
            initializeExampleNotes()
        }

        private fun initializeCourses() {
            courses.add(initializeCourse1())
            courses.add(initializeCourse2())
            courses.add(initializeCourse3())
            courses.add(initializeCourse4())
        }

        private fun initializeExampleNotes() {
            var course: CourseInfo? = getCourse("android_intents")
            if (course != null) {
                course.getModuleByModuleId("android_intents_m01")?.isComplete = true
                course.getModuleByModuleId("android_intents_m02")?.isComplete = true
                course.getModuleByModuleId("android_intents_m03")?.isComplete = true
                notes.add(NoteInfo(course, "Dynamic intent resolution",
                        "Wow, intents allow components to be resolved at runtime"))
                notes.add(NoteInfo(course, "Dynamic intent resolution",
                        "Wow, intents allow components to be resolved at runtime"))
            }
            course = getCourse("android_async")
            if (course != null) {
                course.getModuleByModuleId("android_async_m01")?.isComplete = true
                course.getModuleByModuleId("android_async_m02")?.isComplete = true
                notes.add(NoteInfo(course, "Service default threads",
                        "Did you know that by default an Android Service will tie up the UI thread?"))
                notes.add(NoteInfo(course, "Long running operations",
                        "Foreground Services can be tied to a notification icon"))
            }
            course = getCourse("java_lang")
            if (course != null) {
                course.getModuleByModuleId("java_lang_m01")?.isComplete = true
                course.getModuleByModuleId("java_lang_m02")?.isComplete = true
                course.getModuleByModuleId("java_lang_m03")?.isComplete = true
                course.getModuleByModuleId("java_lang_m04")?.isComplete = true
                course.getModuleByModuleId("java_lang_m05")?.isComplete = true
                course.getModuleByModuleId("java_lang_m06")?.isComplete = true
                course.getModuleByModuleId("java_lang_m07")?.isComplete = true
                notes.add(NoteInfo(course, "Parameters",
                        "Leverage variable-length parameter lists"))
                notes.add(NoteInfo(course, "Anonymous classes",
                        "Anonymous classes simplify implementing one-use types"))
            }
            course = getCourse("java_core")
            if (course != null) {
                course.getModuleByModuleId("java_core_m01")?.isComplete = true
                course.getModuleByModuleId("java_core_m02")?.isComplete = true
                course.getModuleByModuleId("java_core_m03")?.isComplete = true
                notes.add(NoteInfo(course, "Compiler options",
                        "The -jar option isn't compatible with with the -cp option"))
                notes.add(NoteInfo(course, "Serialization",
                        "Remember to include SerialVersionUID to assure version compatibility"))
            }
        }

        fun getCurrentUserName(): String {
            return "Jim Wilson"
        }

        fun getCurrentUserEmail(): String {
            return "jimw@jwhh.com"
        }

        fun getCourse(id: String): CourseInfo? {
            for (course in courses) {
                if (id == course.courseId)
                    return course
            }
            return null
        }

        fun findNote(note: NoteInfo): Int {
            for (index in notes.indices) {
                if (note == notes[index])
                    return index
            }

            return -1
        }

        fun getNotes(course: CourseInfo): List<NoteInfo> {
            val notes = ArrayList<NoteInfo>()
            for (note in notes) {
                if (course == note.course)
                    notes.add(note)
            }
            return notes
        }

        fun removeNote(index: Int) {
            notes.removeAt(index)
        }

        fun getNoteCount(course: CourseInfo): Int {
            var count = 0
            for (note in notes) {
                if (course == note.course)
                    count++
            }
            return count
        }

        fun initializeCourse1(): CourseInfo {
            val modules = ArrayList<ModuleInfo>()
            modules.add(ModuleInfo("android_intents_m01", "Android Late Binding and Intents"))
            modules.add(ModuleInfo("android_intents_m02", "Component activation with intents"))
            modules.add(ModuleInfo("android_intents_m03", "Delegation and Callbacks through PendingIntents"))
            modules.add(ModuleInfo("android_intents_m04", "IntentFilter data tests"))
            modules.add(ModuleInfo("android_intents_m05", "Working with Platform Features Through Intents"))

            return CourseInfo("android_intents", "Android Programming with Intents", modules)
        }

        private fun initializeCourse2(): CourseInfo {
            val modules = ArrayList<ModuleInfo>()
            modules.add(ModuleInfo("android_async_m01", "Challenges to a responsive user experience"))
            modules.add(ModuleInfo("android_async_m02", "Implementing long-running operations as a service"))
            modules.add(ModuleInfo("android_async_m03", "Service lifecycle management"))
            modules.add(ModuleInfo("android_async_m04", "Interacting with services"))

            return CourseInfo("android_async", "Android Async Programming and Services", modules)
        }

        private fun initializeCourse3(): CourseInfo {
            val modules = ArrayList<ModuleInfo>()
            modules.add(ModuleInfo("java_lang_m01", "Introduction and Setting up Your Environment"))
            modules.add(ModuleInfo("java_lang_m02", "Creating a Simple App"))
            modules.add(ModuleInfo("java_lang_m03", "Variables, Data Types, and Math Operators"))
            modules.add(ModuleInfo("java_lang_m04", "Conditional Logic, Looping, and Arrays"))
            modules.add(ModuleInfo("java_lang_m05", "Representing Complex Types with Classes"))
            modules.add(ModuleInfo("java_lang_m06", "Class Initializers and Constructors"))
            modules.add(ModuleInfo("java_lang_m07", "A Closer Look at Parameters"))
            modules.add(ModuleInfo("java_lang_m08", "Class Inheritance"))
            modules.add(ModuleInfo("java_lang_m09", "More About Data Types"))
            modules.add(ModuleInfo("java_lang_m10", "Exceptions and Error Handling"))
            modules.add(ModuleInfo("java_lang_m11", "Working with Packages"))
            modules.add(ModuleInfo("java_lang_m12", "Creating Abstract Relationships with Interfaces"))
            modules.add(ModuleInfo("java_lang_m13", "Static Members, Nested Types, and Anonymous Classes"))

            return CourseInfo("java_lang", "Java Fundamentals: The Java Language", modules)
        }

        private fun initializeCourse4(): CourseInfo {
            val modules = ArrayList<ModuleInfo>()
            modules.add(ModuleInfo("java_core_m01", "Introduction"))
            modules.add(ModuleInfo("java_core_m02", "Input and Output with Streams and Files"))
            modules.add(ModuleInfo("java_core_m03", "String Formatting and Regular Expressions"))
            modules.add(ModuleInfo("java_core_m04", "Working with Collections"))
            modules.add(ModuleInfo("java_core_m05", "Controlling App Execution and Environment"))
            modules.add(ModuleInfo("java_core_m06", "Capturing Application Activity with the Java Log System"))
            modules.add(ModuleInfo("java_core_m07", "Multithreading and Concurrency"))
            modules.add(ModuleInfo("java_core_m08", "Runtime Type Information and Reflection"))
            modules.add(ModuleInfo("java_core_m09", "Adding Type Metadata with Annotations"))
            modules.add(ModuleInfo("java_core_m10", "Persisting Objects with Serialization"))

            return CourseInfo("java_core", "Java Fundamentals: The Core Platform", modules)
        }
    }

}


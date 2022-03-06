package com.iraimjanov.codialapp.db

import android.content.Context
import com.iraimjanov.codialapp.models.Courses
import com.iraimjanov.codialapp.models.Groups
import com.iraimjanov.codialapp.models.Mentors
import com.iraimjanov.codialapp.models.Students

interface DBService {
    fun addCourses(courses: Courses, context: Context): Boolean
    fun showCourses(): ArrayList<Courses>
    fun deleteCourses(courses: Courses):Boolean
    fun getCoursesByID(id: Int): Courses
    fun addMentors(mentors: Mentors, context: Context)
    fun showMentors(): ArrayList<Mentors>
    fun updateMentors(mentors: Mentors, context: Context)
    fun deleteMentors(mentors: Mentors):Boolean
    fun getMentorsByID(id: Int): Mentors
    fun getMentorByCoursesID(courses: Courses)
    fun getAllMentorsByID(id: Int): ArrayList<Mentors>
    fun addGroups(groups: Groups, context: Context): Boolean
    fun showGroups(string: String, context: Context): ArrayList<Groups>
    fun updateGroups(groups: Groups, context: Context)
    fun deleteGroups(groups: Groups):Boolean
    fun getGroupsByMentorsID(mentors: Mentors)
    fun getGroupsByID(id: Int , boolean: Boolean):Groups
    fun startLessonGroup(groups: Groups, context: Context): Boolean
    fun addStudents(students: Students, context: Context)
    fun showStudents(id: Int , boolean: Boolean):ArrayList<Students>
    fun updateStudents(students: Students , context: Context)
    fun deleteStudents(students: Students):Boolean
    fun getStudentByGroupsID(groups: Groups)

}
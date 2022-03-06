package com.iraimjanov.codialapp.myClass

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.iraimjanov.codialapp.Object.Object
import com.iraimjanov.codialapp.R
import com.iraimjanov.codialapp.adapters.CoursesAdapter
import com.iraimjanov.codialapp.databinding.FragmentCoursesBinding
import com.iraimjanov.codialapp.db.MyDBHelper
import com.iraimjanov.codialapp.models.Courses

class ShowCourses(
    var activity: Activity,
    var binding: FragmentCoursesBinding,
    var findNavController: NavController,
) {
    lateinit var arrayListCourses: ArrayList<Courses>
    lateinit var coursesAdapter: CoursesAdapter
    lateinit var myDBHelper: MyDBHelper

    fun showCourses() {
        loadData()
        coursesAdapter = CoursesAdapter(arrayListCourses, object : CoursesAdapter.RVClickCourses {
            override fun onClick(courses: Courses) {
                Object.courses = courses
                findNavController.navigate(Object.navigationID)
            }

        })
        binding.recyclerCourses.adapter = coursesAdapter
    }

    private fun loadData() {
        arrayListCourses = ArrayList()
        myDBHelper = MyDBHelper(activity)
        arrayListCourses = myDBHelper.showCourses()
    }
}
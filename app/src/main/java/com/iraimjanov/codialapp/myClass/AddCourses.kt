package com.iraimjanov.codialapp.myClass

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.navigation.NavController
import com.iraimjanov.codialapp.R
import com.iraimjanov.codialapp.databinding.DialogAddCoursesBinding
import com.iraimjanov.codialapp.databinding.FragmentCoursesBinding
import com.iraimjanov.codialapp.db.MyDBHelper
import com.iraimjanov.codialapp.models.Courses

class AddCourses(
    var activity: Activity,
    var binding: FragmentCoursesBinding,
    var findNavController: NavController,
) {
    private lateinit var bindingDialog: DialogAddCoursesBinding
    lateinit var dialog: AlertDialog
    lateinit var myDBHelper: MyDBHelper
    lateinit var showCourses: ShowCourses
    var booleanAntiBag = true
    fun buildDialog() {
        bindingDialog = DialogAddCoursesBinding.inflate(activity.layoutInflater)
        val alertDialog = AlertDialog.Builder(activity)

        bindingDialog.tvCancel.setOnClickListener {
            dialog.cancel()
        }

        bindingDialog.tvSave.setOnClickListener {
            val name = bindingDialog.edtCoursesName.text.toString().trim()
            val about = bindingDialog.edtCoursesAbout.text.toString().trim()
            if (name.isNotEmpty() && about.isNotEmpty()) {
                myDBHelper = MyDBHelper(activity)
                if (myDBHelper.addCourses(Courses(name, about), activity)) {
                    showCourses = ShowCourses(activity, binding, findNavController)
                    showCourses.showCourses()
                    dialog.cancel()
                }
            }
        }

        alertDialog.setOnCancelListener {
            booleanAntiBag = true
        }

        alertDialog.setView(bindingDialog.root)
        dialog = alertDialog.create()
        dialog.window!!.attributes.windowAnimations = R.style.MyAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (booleanAntiBag) {
            dialog.show()
            booleanAntiBag = false
        }
    }
}
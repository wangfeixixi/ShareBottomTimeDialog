package wangfeixixi.github.com.wiget

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class TestActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)

        verticalLayout {
            val name = editText()
            button("Say Hello") {
             setOnClickListener {
                    toast("Hello, ${name.text}!")

             }
//                onClick {
//                }
            }
        }
    }
}
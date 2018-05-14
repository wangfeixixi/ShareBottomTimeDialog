package wangfeixixi.github.com.mosbysample

import wangfeixixi.github.com.mosbysample.base.BaseP

class HelloP : BaseP<HelloView>() {
    var name: String = ""

    fun testFun(name: String) {
        this.name = name
        println(this.name)
    }

}
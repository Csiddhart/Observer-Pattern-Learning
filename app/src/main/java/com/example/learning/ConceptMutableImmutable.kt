package com.example.learning

object ConceptMutableImmutable {
    //concept of mutable and immutables
    //Mutable --> which size can be changed
    //Immutable --> which size can be changed

    //val--> it is immutable, but It can create list  --> but it is immutable in case of declaration
    //var--> it is mutable

    //mutableListof --> it creates mutable list
    //listof --> it creates immutable list

    @JvmStatic
    fun main(args: Array<String>) {
//        val no:Int=2
//        no=1//since it is val so it can't be changed
//
//        var num:Int=2
//        num=9 //since it is var so it can be changed

         //Mutable list
        var mutablelist= mutableListOf(1,2,3) //eta teh ki holo var diye amra mutable list banalam but oi same name er mutable list ta modify korlam
        println(mutablelist) //why we o val over var in creation of list since we don't want to change the list
        mutablelist= mutableListOf(2,5,6) //this declaration concept is same for immutable also
        println(mutablelist)
        val muta= mutableListOf(6,8,9)
        println(muta)
        //muta=mutableListof(2,7,6)//but here amra same name er mutable list ta korteh parbo nah but aayi mutable list ta k modify korteh parbo
        muta.add(5)
        println(muta)
        muta[1]=9
        println(muta)//now over here amra modify korlam

        //Immutable list
        val immutablelist= listOf(2,5,8)
        println(immutablelist)
        /*immutablelist= listOf(5,8,9)//creation not possible
        immutablelist.add(5)//not possible
        immutablelist[1]=9//not possible*/
    }
}
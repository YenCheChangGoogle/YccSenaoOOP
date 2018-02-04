import {Singleton} from "./Singleton";

function init_Singleton() {
    let singleton1 = new Singleton("data1")
    let singleton2 = new Singleton("data2")
    console.log(singleton1.GetSingletonData())
    console.log(singleton2.GetSingletonData())
    console.log(singleton1 instanceof Singleton)
    console.log(singleton2 instanceof Singleton)
    console.log(singleton1 === singleton2)
}
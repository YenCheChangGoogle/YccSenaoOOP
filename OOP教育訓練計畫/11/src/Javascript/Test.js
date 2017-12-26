function run() {
    var instance1 = Singleton.getInstance();
    var instance2 = Singleton.getInstance();
    alert("Same instance? " + (instance1 === instance2));
}

run();
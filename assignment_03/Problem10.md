### What is Java Garbage Collection? How It Works?. What is finalize method in Java ? When does an Object becomes eligible for Garbage collection in Java?

#### What is Java Garbage Collection? How It Works?: 

In Java destruction of object from memory is done automatically by the JVM. When there is no reference to an object, then that object is assumed to be no longer needed and the memory occupied by the object are released. This technique is called Garbage Collection. This is accomplished by the JVM.
Essentially, it is tracking down all the objects that are still used and marks the rest as garbage. Java’s garbage collection is considered an automatic memory management scheme because programmers do not have to designate objects as ready to be de-allocated. 

#### What is finalize method in java?

The 'finalize' method is a method that the Garbage Collector always calls just before the deletion/destroying the object which is eligible for Garbage Collection, in order to perform any cleanup activities. However, The execution of finalize() is not guaranteed at all. Also, finalize() methods do not work in chaining like constructors. It means when you call a constructor then constructors of all superclasses will be invoked implicitly, But, in case of finalize() methods, this is not followed. Ideally, finalize() of parent class should be called explicitly but it does not happen. Suppose, a class is created and wrote its finalize method. On extrension of the the class does not call super.finalize() in subclass’s finalize() block, then super class’s finalize() will never be invoked.

#### When does an Object becomes eligible for Garbage collection in Java?
In java, when the objects are no longer in use it becomes eligble for garbage collection. The objects are no longer in use means there are no references to such objects. To determine which objects are no longer in use, the JVM intermittently runs this operation called a mark-and-sweep algorithm. A two-step process:

1. The algorithm traverses all object references, starting with the Garbage Collector(GC) roots, and marks every object found as alive.

1. All of the heap memory that is not occupied by marked objects is reclaimed. It is simply marked as free, essentially swept free of unused objects.





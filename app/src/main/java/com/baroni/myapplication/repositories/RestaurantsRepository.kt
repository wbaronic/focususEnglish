package com.baroni.myapplication.repositories

import com.baroni.myapplication.R


data class Category(val name: String, val tagLine: String, val imageId : Int, val word: List<String>, val prhase: List<String> , val images: List<String>) {

}

data class Word(val name: String, val tagLine: String, val list: List<String>)


val christianWords = listOf(
    "God",
    "Jesus",
    "Faith",
    "Grace",
    "Bible",
    "Prayer",
    "Church",
    "Salvation",
    "Cross",
    "Love",
    "Redemption",
    "Atonement",
    "Resurrection",
    "Holy Spirit",
    "Sin",
    "Repentance",
    "Heaven",
    "Eternal Life",
    "Savior",
    "Worship"
)


fun images() : List<String> {
val url="https://th.bing.com/th/id/OIP.roeJGz3eeyhxK3XRQ0LxpQHaFj?rs=1&pid=ImgDetMain"
    val urlList = List(30) { url }

   return urlList
}


val christianPhrases = listOf(
    "John 3:16 - For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life.",
    "Matthew 28:19 - Go therefore and make disciples of all nations, baptizing them in the name of the Father and of the Son and of the Holy Spirit.",
    "Hebrews 11:1 - Now faith is the assurance of things hoped for, the conviction of things not seen.",
    "Ephesians 2:8 - For by grace you have been saved through faith. And this is not your own doing; it is the gift of God.",
    "Psalm 119:105 - Your word is a lamp to my feet and a light to my path.",
    "Philippians 4:6-7 - Do not be anxious about anything, but in everything by prayer and supplication with thanksgiving let your requests be made known to God. And the peace of God, which surpasses all understanding, will guard your hearts and your minds in Christ Jesus.",
    "Matthew 18:20 - For where two or three are gathered in my name, there am I among them.",
    "Romans 10:9 - Because, if you confess with your mouth that Jesus is Lord and believe in your heart that God raised him from the dead, you will be saved.",
    "1 Corinthians 1:18 - For the word of the cross is folly to those who are perishing, but to us who are being saved, it is the power of God.",
    "1 Corinthians 13:13 - So now faith, hope, and love abide, these three; but the greatest of these is love.",
    "Ephesians 1:7 - In him we have redemption through his blood, the forgiveness of our trespasses, according to the riches of his grace.",
    "Romans 5:11 - More than that, we also rejoice in God through our Lord Jesus Christ, through whom we have now received reconciliation.",
    "1 Corinthians 15:3-4 - For I delivered to you as of first importance what I also received: that Christ died for our sins in accordance with the Scriptures, that he was buried, that he was raised on the third day in accordance with the Scriptures.",
    "John 14:26 - But the Helper, the Holy Spirit, whom the Father will send in my name, he will teach you all things and bring to your remembrance all that I have said to you.",
    "Acts 3:19 - Repent therefore, and turn back, that your sins may be blotted out.",
    "Revelation 21:4 - He will wipe away every tear from their eyes, and death shall be no more, neither shall there be mourning, nor crying, nor pain anymore, for the former things have passed away.",
    "John 11:25-26 - Jesus said to her, 'I am the resurrection and the life. Whoever believes in me, though he die, yet shall he live, and everyone who lives and believes in me shall never die. Do you believe this?'",
    "John 3:5 - Jesus answered, 'Truly, truly, I say to you, unless one is born of water and the Spirit, he cannot enter the kingdom of God.'",
    "Psalm 95:6 - Oh come, let us worship and bow down; let us kneel before the Lord, our Maker!"
)


fun frases () : List<String> {
    val javaProgrammingPhrases = listOf(
        "Java is versatile",
        "Object-oriented programming",
        "Classes define structure",
        "Methods perform actions",
        "Variables store data",
        "Inheritance promotes reusability",
        "Polymorphism enables flexibility",
        "Encapsulation hides complexity",
        "Abstraction simplifies usage",
        "Interfaces define contracts",
        "Abstract classes provide blueprints",
        "Constructors initialize objects",
        "Instances represent entities",
        "Static members belong to class",
        "Final keyword ensures immutability",
        "Public access for everyone",
        "Private restricts access",
        "Protected allows subclass access",
        "Packages organize code",
        "Imports bring in external code",
        "Override for method customization",
        "Overload for multiple methods",
        "Super calls parent methods",
        "This refers to current instance",
        "Null indicates absence of value",
        "Exceptions handle errors",
        "Try-Catch for error handling",
        "Finally for cleanup",
        "Throw signals exceptions",
        "Checked exceptions require handling",
        "Unchecked exceptions are runtime",
        "Arrays store multiple values",
        "Lists dynamic-sized collections",
        "Sets unique elements only",
        "Maps key-value pairs",
        "Collections framework for data structures",
        "Iterators traverse collections",
        "Lambdas for functional programming",
        "Streams for processing data",
        "Functional interfaces allow lambda use",
        "Generics provide type safety",
        "Wildcards enable flexible typing",
        "Type casting converts types",
        "Wrapper classes for primitives",
        "Autoboxing converts primitive to object",
        "Unboxing converts object to primitive",
        "Reflection inspects at runtime",
        "Annotations add metadata",
        "Enums represent fixed set",
        "Serializable for object persistence",
        "Cloneable for object copying",
        "Comparable for natural ordering",
        "Comparator for custom ordering",
        "Threads execute concurrently",
        "Runnable for thread logic",
        "Synchronized for thread safety",
        "Mutex for mutual exclusion",
        "Semaphore for controlled access",
        "Concurrency deals with simultaneous execution",
        "Lock for synchronization",
        "Deadlock for resource conflicts",
        "Monitor for synchronization",
        "Garbage collection manages memory",
        "Heap stores objects",
        "Stack manages method calls",
        "Memory management crucial for performance",
        "JVM interprets bytecode",
        "JRE includes JVM and libraries",
        "JDK includes compiler and tools",
        "Bytecode is platform-independent",
        "Compilation converts source to bytecode",
        "Decompilation reverse engineer bytecode",
        "Serialization converts objects to bytes",
        "Deserialization restores objects",
        "I/O for input and output",
        "File operations for file handling",
        "Readers and Writers for text processing",
        "Buffers for efficient I/O",
        "Scanners for tokenization",
        "Input from user",
        "Output to display",
        "Regex for pattern matching",
        "Patterns define search criteria",
        "Matchers check pattern against text",
        "API provides application interface",
        "Libraries offer pre-built functionality",
        "Frameworks provide structure",
        "Maven for project management",
        "Gradle for build automation",
        "JUnit for unit testing",
        "Tests validate code",
        "Debugging identifies and fixes issues",
        "IDE for development environment",
        "Version control tracks changes",
        "Git for distributed version control",
        "GitHub for hosting repositories",
        "Bitbucket for code collaboration",
        "Merge combines changes",
        "Branch for parallel development",
        "Pull requests propose changes",
        "Push updates remote repository"
    )

    return javaProgrammingPhrases
}




fun palavras () : List<String>{



    val javaProgrammingWords = listOf(
        "Java",
        "Object",
        "Class",
        "Method",
        "Variable",
        "Inheritance",
        "Polymorphism",
        "Encapsulation",
        "Abstraction",
        "Interface",
        "Abstract",
        "Constructor",
        "Instance",
        "Static",
        "Final",
        "Public",
        "Private",
        "Protected",
        "Package",
        "Import",
        "Override",
        "Overload",
        "Super",
        "This",
        "Null",
        "Exception",
        "Try",
        "Catch",
        "Finally",
        "Throw",
        "Throws",
        "Checked",
        "Unchecked",
        "Array",
        "List",
        "Set",
        "Map",
        "Collection",
        "Iterator",
        "Lambda",
        "Stream",
        "Functional",
        "Generics",
        "Wildcard",
        "Type",
        "Cast",
        "Wrapper",
        "Autoboxing",
        "Unboxing",
        "Reflection",
        "Annotation",
        "Enum",
        "Interface",
        "Serializable",
        "Cloneable",
        "Comparable",
        "Comparator",
        "Thread",
        "Runnable",
        "Synchronized",
        "Mutex",
        "Semaphore",
        "Concurrency",
        "Lock",
        "Deadlock",
        "Monitor",
        "Garbage",
        "Heap",
        "Stack",
        "Memory",
        "JVM",
        "JRE",
        "JDK",
        "Bytecode",
        "Compilation",
        "Decompilation",
        "Serialization",
        "Deserialization",
        "I/O",
        "File",
        "Reader",
        "Writer",
        "Buffer",
        "Scanner",
        "Input",
        "Output",
        "Regex",
        "Pattern",
        "Matcher",
        "API",
        "Library",
        "Framework",
        "Maven",
        "Gradle",
        "JUnit",
        "Test",
        "Debug",
        "IDE",
        "Version",
        "Control",
        "Git",
        "GitHub",
        "Bitbucket",
        "Merge",
        "Branch",
        "Pull",
        "Push")


    return javaProgrammingWords
}

class RestaurantsRepository {




    private val categories = listOf(
        Category("JAVA",
            "Trainning Java Words!", R.drawable.java, palavras(), frases(),images()),

        Category("Bible",
          "Trainning Bible Words", R.drawable.ingles, christianWords, christianPhrases,images())
//        Restaurant("Big Belly Noodles",
//            "Delicious noodles", R.drawable.restaurant_03),
//        Restaurant("Cakery",
//            "Cakes for every occasion", R.drawable.restaurant_04),
//        Restaurant("Pan Asia",
//            "The best Asian food", R.drawable.restaurant_05),
//        Restaurant("House of Pancakes",
//            "Best for breakfast", R.drawable.restaurant_06),
//        Restaurant("Sizzling Steakhouse",
//            "Come for the sizzle", R.drawable.restaurant_07),
//        Restaurant("Something fishy",
//            "Everything from the sea", R.drawable.restaurant_08),
//        Restaurant("Pasta Ya Gotcha",
//            "Pastas and more", R.drawable.restaurant_09),
//        Restaurant("Healthy and Yummy",
//            "Can't believe it's healthy!", R.drawable.restaurant_10),
    )

    fun getRestaurant(name : String): Category? {
        for (restaurant in categories) {
            if (restaurant.name == name) {
                return restaurant
            }
        }

        return null
    }

    fun getRestaurants(): List<Category> {
        return categories
    }
}
.class public TestPassByValue
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static b I
.field private static f I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 10
    putstatic TestPassByValue/a I
    ldc "Global variable a before call to function "
    getstatic TestPassByValue/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Global variable a before call to function "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    getstatic TestPassByValue/a I
    new TestPassByValue
    dup
    invokespecial TestPassByValue/<init>()V
    invokevirtual TestPassByValue/second(I)V

return
.limit locals 32
.limit stack 40
.end method

.method public second(I)V
    getstatic TestPassByValue/f I

    ldc "Passed value is "
    getstatic TestPassByValue/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Passed value is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	TestPassByValue/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestPassByValue/_standardIn LPascalTextIn;

 new TestPassByValue
    dup
    invokespecial TestPassByValue/<init>()V
    invokevirtual TestPassByValue/main()V

    getstatic	TestPassByValue/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method

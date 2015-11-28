.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static c I
.field private static doDob F
.field private static fort F
.field private static str F

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 4
    ldc 10.2
    ldc "hello"
    getstatic Test/a I
    ldc 5
    imul
    putstatic Test/a I
    getstatic Test/a I
    ldc 5
    isub
    putstatic Test/a I
    ldc 5

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "5"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "hello"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "hello"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "Printing integer "
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing integer "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "printing Double "
    getstatic Test/doDob F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "printing Double "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/doDob F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "print String error "
    getstatic Test/str F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "print String error "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/str F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "multiple variable "
    getstatic Test/a I
    getstatic Test/doDob F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "multiple variable "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic Test/doDob F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    new Test
    dup
    invokespecial Test/<init>()V
    invokevirtual Test/second()V

return
.limit locals 16
.limit stack 32
.end method

.method public second()V
    ldc 5
    ldc 6.0

return
.limit locals 16
.limit stack 32
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Test/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Test/_standardIn LPascalTextIn;

 new Test
    dup
    invokespecial Test/<init>()V
    invokevirtual Test/main()V

    getstatic	Test/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method

.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static b F
.field private static d F
.field private static doDob F

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 10.2
    putstatic Test/doDob F
    getstatic Test/doDob F
    ldc 2
    i2f
    fmul
    putstatic Test/d F
    ldc 320000.0
    ldc 2
    i2f
    fmul
    putstatic Test/b F
    ldc "mul"
    getstatic Test/b F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "mul"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/b F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/doDob F
    ldc 2
    i2f
    fdiv
    putstatic Test/d F
    ldc "div"
    getstatic Test/d F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "div"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/d F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


return
.limit locals 32
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

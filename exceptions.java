Throwable
├── Error
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
│
└── Exception
    ├── Checked Exceptions
    │   ├── IOException
    │   │   └── FileNotFoundException
    │   ├── SQLException
    │   └── ClassNotFoundException
    │
    └── Unchecked Exceptions (RuntimeException)
        ├── NullPointerException
        ├── IllegalArgumentException
        ├── IndexOutOfBoundsException
        └── ArithmeticException

1. Throwable is the top-level superclass.
2. Error: Serious problems that applications should not try to catch.
3. Exception: Conditions that applications might want to catch.
   1. Checked Exceptions: Must be declared or handled.
   2. Unchecked Exceptions (RuntimeException): Don't require explicit handling.

STREAMS: sequence of data either it is bytes or characters(unicode characters).
=> it is an abstraction that java provides.
=> java implements these within class hirearchy in java.io package.

1. Byte streams: (it can be audioInputstream, ByteArrayInputStream, FileInputstream, FilterInputStream, objectInputStream, StringBufferInputStream).
    1. Input stream.
    2. Output Stream.
2. Character Stream:
    1. Reader
    2. Writer

=> InputStreamReader converts byte stream to character stream and if we use BufferedReader we need to use InputStreamReader to  read the stream
    of characters from InputStreamReader.
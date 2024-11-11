## 使用了并发工具类库，并不等于就没有线程安全问题了

- 2.1.1 没有意识到线程重用导致用户信息错乱的bug：threadlocal
- 2.1.2 使用了线程安全的并发工具，并不代表解决了所有线程安全问题：concurrenthashmapmisuse
- 2.1.3 没有充分了解并发工具的特性，从而无法发挥其威力：concurrenthashmapperformance
- 2.1.4 没有认清并发工具的使用场景，因而导致性能问题：copyonwritelistmisuse
- （思考）ConcurrentHashMap的putIfAbsent方法computeIfAbsent方法有什么区别？：ciavspia

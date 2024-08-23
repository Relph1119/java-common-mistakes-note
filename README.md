# 《Java 开发坑点解析：从根因分析到最佳实践》读书笔记

## 问题排查

### 1 启动ES集群遇到如下报错：

```text
ERROR: [1] bootstrap checks failed
[1]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
```

**解决方案：**

1. 使用命令提示符（CMD）进入docker-desktop子系统
```shell
wsl -d docker-desktop
```

2. 编辑`/etc/sysctl.conf`
```shell
vi /etc/sysctl.conf
```
输入：`vm.max_map_count=262144`，长按Shift并快速按两下z（即`Shift + zz`）保存并退出。

3. 检查修改是否成功
```shell
grep vm.max_map_count /etc/sysctl.conf
```

4. 立即生效
```shell
sysctl -p
```
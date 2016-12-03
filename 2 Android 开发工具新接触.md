# 安装 Gradle 比较快速的方法
找到 `C:\Users\<用户名>\.gradle\wrapper\dists\` 目录，将官网上下载的 zip 压缩包替换进来，android studio 会自动解压。

# 导入 Android Studio 工程小技巧
当某个项目使用的 Gradle 版本在本地不存在的时候，Android Studio 就会去下载这个版本的 Gradle。为了避免去下载，可以在本地用当前版本的 Gradle 创建一个正常的项目，然后用里面的 gradle 文件夹和 build.gradle 文件替换要导入项目中的这两个文件。

# adb 命令的使用
```shell
adb version  // 查看 adb 版本

adb install -r 应用程序.apk  // 安装应用

adb push <local> <remote>  // 推送文件到手机

adb pull <remote> <local>  // 拉取文件

adb shell // 进入 shell

logcat  // 查看 Log

adb shell pm list packages -f  // 输出所有已经安装的应用

adb shell input keyevent <键值>  // 模拟按键输入

adb shell input touchscreen <x1> <y1> <x2> <y2>  // 模拟滑动

adb shell am start -n 包名/包名 + 类名  // 启动一个 Activity

adb shell screenrecord /sdcard/demo.mp4  // 还可以录屏。。。

adb reboot  // 重新启动
```
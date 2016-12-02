# 安装 Gradle 比较快速的方法
找到 C:\Users\<用户名>\.gradle\wrapper\dists\ 目录，将官网上下载的 zip 压缩包替换进来，android studio 会自动解压。

# 导入 Android Studio 工程小技巧
当某个项目使用的 Gradle 版本在本地不存在的时候，Android Studio 就会去下载这个版本的 Gradle。为了避免去下载，可以在本地用当前版本的 Gradle 创建一个正常的项目，然后用里面的 gradle 文件夹和 build.gradle 文件替换要导入项目中的这两个文件。


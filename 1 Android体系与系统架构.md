# 1.2 Android 系统架构
- `Linux`（最底层最核心）
- `Dalvik` 与 `ART`（`Android` 运行环境虚拟机，每个 `APP` 都会分配一个单独的虚拟机保证互相之间不受干扰，保持独立。`ART` 安装时就进行编译。）
- `Framework`
- `Standard libraries`（开发过程中可以使用的开发库）
- `Application`（包含 `Android Manifest、Dalvik Classes、Resource Bundle` 等）

# 1.3 Android APP 组件架构
指的是 `Activity、BroadcastReceiver、ContentProvider` 和 `Service` 四大组件。

## 应用运行上下文对象 Context
- `Activity、Service、Application` 都继承自 `Context`
- 在创建以上三项的时候会创建 `Context`（创建 `Context` 的时机就是在创建 `Context` 实现类的时候）
- 可以通过 `getApplicationContext()` 方法来获取整个 App 的 `Context`

# 1.4 Android 系统源代码目录与系统目录

## 1.4.1 Android 系统源代码目录
- 查看 Android 源代码的网站：http://androidxref.com/
- android 每一个最小的功能单位的目录下都会有一个 `Makefile` 文件

## 1.4.2 Android 系统目录
- `/system/app/`  系统 App
- `/system/bin/`  Linux自带的组件
- `/system/build.prop`  系统的属性信息
- `/system/fonts/`  root后可以下载 TTF 格式字体替换原字体
- `/system/framework/` 系统的核心文件、框架层
- `/system/lib/`  共享库（.so）文件
- `/system/media/`  保存系统提示音、系统铃声
- `/system/media/audio/`  Android 系统默认的铃声，alarms 目录是闹铃提醒，notification 目录是短信或提示音，ringtones 目录是来电铃声，ui 目录则是一些界面音效
- `/system/usr/`  用户的配置文件，如键盘布局、共享、时区文件
- `/data/app/`  data 目录包含用户大部分数据信息，/data/app/目录包含用户安装的 App 或升级的 App
- `/data/data/`  App 数据信息、文件信息、数据库信息
- `/data/system/`  手机各项系统信息
- `/data/misc/`  Wi-Fi、VPN信息

## 1.4.3 Android App 文件目录
- Android Studio 中的 Project 相当于 Eclipse 的 Workspace，Android Studio 中的 Module 相当于 Eclipse 的 Project。
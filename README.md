# Build SDK With Golang

如何使用golang编写sdk并将其接入到你的android应用中

## Before All

将该项目 `git clone` 到本地。

## Build `.aar` with [gomobile](https://github.com/golang/mobile)

### 安装

#### SDK & NDK

需要确保你的android SDK 与 NDK 均已安装完成且可用。

#### gomobile

- go环境
- `go get golang.org/x/mobile/cmd/gomobile`（需要科学上网）
- `gomobile` 确认安装成功（如果仍找不到，自行配置环境变量）
- `gomobile init -ndk <你的ndk安装位置>`

### 构建

> 目前 gomobile 与 `go mod` 的工作模式会有冲突（[issue27234](https://github.com/golang/go/issues/27234)）。所以首先，go项目需要配置在`$GOPATH`中。

主要步骤：

- 将 `<你clone到本地的项目路径>/sample/go` 加入你的 `$GOPATH` 中
- `gomobile bind -target=android hello`

在构建完成后，你将得到：

- `hello.aar`
- `hello-sources.jar`

如果在编译期指定平台架构，可以让`.aar`更加轻量：

```shell
gomobile bind -target=android/arm hello
gomobile bind -target=android/arm64 hello
gomobile bind -target=android/amd64 hello
```

### 使用

- 用 android studio 打开 `<你clone到本地的项目路径>/sample/android/`
- 将编译得到的 `hello.aar` 复制到 `src` 同级的 `libs` 目录下
- （代码内已有）在 **app级** `build.gradle` 中加入：

    ```groovy
    repositories {
        flatDir {
            dirs 'libs'
        }
    }
    ```

- （代码内已有）在 app级 `build.gradle` 中加入 `implementation(name:'hello', ext:'aar')`
- Rebuild project
- （代码内已有）在项目中调用即可
- 编译、安装、运行，你将可以看到 `Hello, williamfzc!` 字样出现

## Build `.so`

TODO

## 引用

- [GOMOBILE写Android和iOS移动端SDK](https://blog.csdn.net/win_lin/article/details/60956485)
- [如何在Android Studio添加本地aar包引用](https://my.oschina.net/u/1177694/blog/598919)
- [Golang生成共享库(shared library)以及Golang生成C可调用的动态库.so和静态库.a](https://blog.csdn.net/linuxandroidwince/article/details/78723441)
- [Go与动态链接库](http://z-rui.github.io/post/2016/07/golang-shared-library/)
- [go语言动态库的编译和使用](https://www.jianshu.com/p/22b46d6bf196)
- [Android Studio 调用so库](https://www.jianshu.com/p/27de58017a71)

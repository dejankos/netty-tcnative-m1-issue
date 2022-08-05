# netty tc native M1 issue

[Netty issue 12669](https://github.com/netty/netty/issues/12669)


Netty OpenSsl with tc-native support on linux-aarch_64 fails with SIGSEGV


| Docker Image                                  | Compatibility layer | `OpenSsl.isAvailable()` | Comment                              |
|-----------------------------------------------|---------------------|:------------------------|--------------------------------------|
| bellsoft/liberica-openjdk-alpine-musl:11.0.16 | libc6-compat        |                         | Fails with `SIGSEGV`                 |
| bellsoft/liberica-openjdk-alpine-musl:11.0.16 | gcompat             | NO                      | Fails to load any of the native libs |
| bellsoft/liberica-openjdk-alpine:11.0.16      |                     | YES                     | Works as expected                    |


## Docker version

Engine:  
Version:          20.10.17  
API version:      1.41 (minimum version 1.12)
OS/Arch:          linux/arm64  
Experimental:     false  
containerd:  
Version:          1.6.6  
GitCommit:        10c12954828e7c7c9b6e0ea9b0c02b01407d3ae1  
runc:  
Version:          1.1.2  
GitCommit:        v1.1.2-0-ga916309  
docker-init:  
Version:          0.19.0  
GitCommit:        de40ad0  

## HW

Chip:	Apple M1 Max  
Total Number of Cores:	10 (8 performance and 2 efficiency)   

# How to run

To reproduce the issue on M1 run:

```bash
docker build -t tc_native_issue -f Dockerfile_Alpine_Musl_libc6-compat . && docker run -v ${PWD}:/data tc_native_issue
```

# Error log

Included in project root folder `hs_err_pid1.log`.

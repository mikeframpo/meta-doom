# meta-doom

doom build for arm devices targeting framebuffer.

## Setup and build

Clone the sources.
```
mkdir poky-qemuarm && cd poky-qemuarm
git clone git@github.com:mikeframpo/meta-doom.git sources/meta-doom
```

Install kas
`TODO`

Run the build
```
kas build sources/meta-doom/kas-quemuarm.yml
```

## Run the target

```
$kas shell sources/meta-doom/kas-quemuarm.yml
$cp meta-doom/conf/custom-qemuarm.qemuboot.conf ../build/tmp/deploy/images/qemuarm/
$DISPLAY=:0 runqemu qemuarm serialstdio
```

will boot the emulator with a console on the terminal and graphical display.

## Run doom (not working yet :-( )

```
prboom-plus -width 240 -height 320 -complevel 17
```

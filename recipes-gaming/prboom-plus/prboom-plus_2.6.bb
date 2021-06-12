
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=14aa9744482b9e7ee47eef837e04c26e"

SRC_URI = " \
    git://github.com/coelckers/prboom-plus;protocol=https;subpath=prboom2 \
    file://freedoom1.wad \
    file://0001-hacking-the-build-to-make-it-cross-compile.patch;patchdir=${WORKDIR}
"

# Modify these as desired
PV = "2.6"
SRCREV = "361b86cba437d9a45b9fb0e9feb8dd1ce5194c46"
S = "${WORKDIR}/prboom2"

DEPENDS = "virtual/libsdl2"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Debug -DBUILD_GL=OFF"

inherit cmake

BBCLASSEXTEND = "native nativesdk"

do_install() {
    install -d ${D}${bindir} \
        ${D}${datadir}/games/doom

	install -m 0755 ${B}/prboom-plus \
        ${D}${bindir}/prboom-plus
    #install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
    
    install -m 0644 ${WORKDIR}/freedoom1.wad \
        ${D}${datadir}/games/doom/
    
    #echo "wad" > ${D}${datadir}/games/doom/prboom.wad
}

FILES_${PN} += "${datadir}/games/doom/freedoom1.wad"


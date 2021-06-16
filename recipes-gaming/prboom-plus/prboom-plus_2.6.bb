
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=14aa9744482b9e7ee47eef837e04c26e"

SRC_URI = " \
    git://github.com/coelckers/prboom-plus;protocol=https;subpath=prboom2 \
    file://freedoom1.wad \
"

# Modify these as desired
PV = "2.6"
SRCREV = "361b86cba437d9a45b9fb0e9feb8dd1ce5194c46"
S = "${WORKDIR}/prboom2"

DEPENDS = "virtual/libsdl2 prboom-plus-native"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Debug -DBUILD_GL=OFF"
EXTRA_OECMAKE_class-target += "-DIMPORT_EXECUTABLES=${BASE_WORKDIR}/${BUILD_SYS}/${PN}-native/${EXTENDPE}${PV}-${PR}/build/ImportExecutables.cmake"

inherit cmake

BBCLASSEXTEND = "native nativesdk"

do_install() {
    install -d ${D}${bindir} \
        ${D}${datadir}/games/doom

	install -m 0755 ${B}/prboom-plus \
        ${D}${bindir}/prboom-plus

    install -m 0644 ${B}/prboom-plus.wad \
        ${D}${datadir}/games/doom/
    
    install -m 0644 ${WORKDIR}/freedoom1.wad \
        ${D}${datadir}/games/doom/
}

FILES_${PN} += "${datadir}/games/doom/freedoom1.wad"
FILES_${PN} += "${datadir}/games/doom/prboom-plus.wad"



FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://directfbrc \
"

FILES_${PN} += " \
    ${sysconfdir}/* \
"

do_install_append() {
    install -d ${D}/${sysconfdir}
    install ${WORKDIR}/directfbrc ${D}/${sysconfdir}
}

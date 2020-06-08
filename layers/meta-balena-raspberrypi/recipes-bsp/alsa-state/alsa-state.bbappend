ALLOW_EMPTRY_${PN} = "1"

do_install_append () {
    rm -rf ${D}${sysconfdir}
}

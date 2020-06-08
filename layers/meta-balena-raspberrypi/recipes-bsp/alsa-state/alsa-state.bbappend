FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SCR_URI_append = " file://asound_4mic.conf"

do_install_append () {
    install -m 0644 ${WORKDIR}/asound_4mic.conf ${D}${sysconfdir}/asound.conf
}

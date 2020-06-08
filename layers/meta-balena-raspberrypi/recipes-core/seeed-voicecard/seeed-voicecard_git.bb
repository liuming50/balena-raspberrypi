SUMMARY = "Seeed-voicecard sound device driver kernel module"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/respeaker/seeed-voicecard;protocol=https"

SRCREV = "6b4133b5f056fd0218f3ffd197df45fab2ae1ef7"
PV = "0.0.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "seeed-voicecard.service"

RDEPENDS_${PN} = "alsa-utils bash"

do_compile () {
	:
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/seeed-voicecard ${D}${bindir}

    install -d ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/asound_2mic.conf ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/asound_4mic.conf ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/asound_6mic.conf ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/ac108_6mic.state ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/ac108_asound.state ${D}${sysconfdir}/voicecard
    install -m 0644 ${S}/wm8960_asound.state ${D}${sysconfdir}/voicecard

    lnr ${D}${sysconfdir}/voicecard/asound_4mic.conf ${D}${sysconfdir}/asound.conf

    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${S}/seeed-voicecard.service ${D}${systemd_unitdir}/system
}

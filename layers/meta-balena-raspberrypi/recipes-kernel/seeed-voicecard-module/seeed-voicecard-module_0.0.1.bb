SUMMARY = "Seeed-voicecard sound device driver kernel module"
LICENSE = "CLOSED"

inherit module

SRC_URI = "git://github.com/respeaker/seeed-voicecard;protocol=https"

SRCREV = "6b4133b5f056fd0218f3ffd197df45fab2ae1ef7"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'KERNELRELEASE="4.19.75" -C ${STAGING_KERNEL_DIR} M=${S}'

KERNEL_MODULE_AUTOLOAD = "snd-soc-seeed-voicecard snd-soc-ac108 snd-soc-wm8960"

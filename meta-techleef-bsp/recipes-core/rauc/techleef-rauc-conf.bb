SUMMARY = "Techleef RAUC system configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

RPROVIDES:${PN} += "virtual-rauc-conf"

INHIBIT_DEFAULT_DEPS = "1"
do_compile[noexec] = "1"

SRC_URI = "file://system.conf"

do_install() {
    install -d ${D}${sysconfdir}/rauc
    install -m 0644 ${WORKDIR}/system.conf ${D}${sysconfdir}/rauc/system.conf
}

FILES:${PN} += "${sysconfdir}/rauc/system.conf"

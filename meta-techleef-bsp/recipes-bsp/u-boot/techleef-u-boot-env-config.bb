SUMMARY = "Techleef U-Boot environment configuration"
DESCRIPTION = "Configuration for accessing the U-Boot environment from Linux"
LICENSE = "CLOSED"

SRC_URI = "file://fw_env.config"
S = "${WORKDIR}"

inherit allarch

do_install() {
    install -D -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

FILES:${PN} = "${sysconfdir}/fw_env.config"

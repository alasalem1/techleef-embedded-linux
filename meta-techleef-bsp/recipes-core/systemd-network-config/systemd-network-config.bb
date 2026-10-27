SUMMARY = "Techleef systemd network configuration"
DESCRIPTION = "Configure DHCP, Wi-Fi and SSH for Techleef"
LICENSE = "CLOSED"

SRC_URI = " \
    file://20-techleef-ethernet.network \
    file://25-techleef-wifi.network \
    file://wpa_supplicant-wlan0.conf \
    file://techleef-wpa-supplicant-wlan0.service \
    file://authorized_keys \
    file://10-techleef-auth.conf \
"

S = "${WORKDIR}"

inherit allarch systemd

SYSTEMD_SERVICE:${PN} = "techleef-wpa-supplicant-wlan0.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -d ${D}${systemd_system_unitdir}
    install -d -m 0700 ${D}${sysconfdir}/skel/.ssh
    install -d ${D}${sysconfdir}/ssh/sshd_config.d

    install -m 0644 ${WORKDIR}/20-techleef-ethernet.network \
        ${D}${sysconfdir}/systemd/network/20-techleef-ethernet.network

    install -m 0644 ${WORKDIR}/25-techleef-wifi.network \
        ${D}${sysconfdir}/systemd/network/25-techleef-wifi.network

    install -m 0600 ${WORKDIR}/wpa_supplicant-wlan0.conf \
        ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -m 0644 ${WORKDIR}/techleef-wpa-supplicant-wlan0.service \
        ${D}${systemd_system_unitdir}/techleef-wpa-supplicant-wlan0.service

    install -m 0600 ${WORKDIR}/authorized_keys \
        ${D}${sysconfdir}/skel/.ssh/authorized_keys

    install -m 0644 ${WORKDIR}/10-techleef-auth.conf \
        ${D}${sysconfdir}/ssh/sshd_config.d/10-techleef-auth.conf
}

FILES:${PN} = " \
    ${sysconfdir}/systemd/network/20-techleef-ethernet.network \
    ${sysconfdir}/systemd/network/25-techleef-wifi.network \
    ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf \
    ${systemd_system_unitdir}/techleef-wpa-supplicant-wlan0.service \
    ${sysconfdir}/skel/.ssh/authorized_keys \
    ${sysconfdir}/ssh/sshd_config.d/10-techleef-auth.conf \
"

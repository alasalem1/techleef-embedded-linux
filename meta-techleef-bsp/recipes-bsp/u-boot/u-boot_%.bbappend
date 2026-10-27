FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:techleef-rpi3w64 = " file://techleef-bootcount.cfg"

do_configure:append:techleef-rpi3w64() {
    merge_config.sh -m ${B}/.config ${WORKDIR}/techleef-bootcount.cfg
    oe_runmake oldconfig
}

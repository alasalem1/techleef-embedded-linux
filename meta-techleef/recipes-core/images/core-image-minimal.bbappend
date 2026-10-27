IMAGE_INSTALL:append = " libubootenv-bin"
IMAGE_INSTALL:append = " techleef-u-boot-env-config"
IMAGE_INSTALL:append = " systemd-network-config"
IMAGE_INSTALL:append = " wpa-supplicant openssh-sshd linux-firmware-rpidistro-bcm43430"
IMAGE_INSTALL:append = " iproute2"
IMAGE_INSTALL:append = " kernel-modules"

inherit extrausers

EXTRA_USERS_PARAMS = " \
    useradd -m -s /bin/sh techleef; \
    usermod -p '\$6\$h1dv6htXT6ls534C\$tTdIInz2Z42wJS26fKq5AaEtQUjTzDdJ3i0Zgceu.yvCXL22NZTyuJqYfiQAJwUtoUgczqcbDYVfdFi89/ZJs.' techleef; \
"


# Techleef Wi-Fi Configuration

This directory contains the Wi-Fi configuration files for the
Techleef Embedded Linux project.

## Wi-Fi credentials

The real Wi-Fi configuration contains private network credentials.
For security reasons, it is excluded from Git.

The following files are used:

- `wpa_supplicant-wlan0.conf.example`: example configuration
  with placeholder credentials. This file is tracked by Git.
- `wpa_supplicant-wlan0.conf`: private configuration containing
  the real Wi-Fi name and password. This file must never be
  committed to Git.

## Setup before building the image

1. Open a terminal at the project root.

2. Go to this directory:

   ```bash
   cd meta-techleef-bsp/recipes-core/systemd-network-config
   ```

3. Copy the example configuration:

   ```bash
   cp files/wpa_supplicant-wlan0.conf.example \
      files/wpa_supplicant-wlan0.conf
   ```

4. Edit the private configuration:

   ```bash
   nano files/wpa_supplicant-wlan0.conf
   ```

5. Replace the placeholders with your own Wi-Fi credentials:

   ```conf
   network={
       ssid="YOUR_WIFI_SSID"
       psk="YOUR_WIFI_PASSWORD"
       key_mgmt=WPA-PSK
   }
   ```

6. Save the file and set secure permissions:

   ```bash
   chmod 600 files/wpa_supplicant-wlan0.conf
   ```

7. Return to the project root:

   ```bash
   cd -
   ```

8. Build the image using KAS:

   ```bash
   ./docker/docker.sh build kas/kas-core-image-minimal-rpi3.yml
   ```

## Security

- Never commit `wpa_supplicant-wlan0.conf`.
- Never put real Wi-Fi credentials in this README.
- Only commit the example configuration.


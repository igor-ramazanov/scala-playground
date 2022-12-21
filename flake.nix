{
  description = "virtual environments";

  inputs.devshell.url = "github:numtide/devshell";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, flake-utils, devshell, nixpkgs }:
    flake-utils.lib.eachDefaultSystem (system: {
      devShell = let
        pkgs = import nixpkgs {
          inherit system;
          overlays = [ devshell.overlay ];
        };
      in pkgs.devshell.mkShell {
        packages = with pkgs; [
          clang
          libcxxabi.dev
          libcxxabi.out
          openssl.dev
          openssl.out
          s2n-tls.dev
          s2n-tls.out
          zlib.dev
          zlib.static
        ];
        env = [
          {
            name = "LIBRARY_PATH";
            prefix = "$DEVSHELL_DIR/lib";
          }
          {
            name = "C_INCLUDE_PATH";
            prefix = "$DEVSHELL_DIR/include";
          }
          {
            name = "LLVM_BIN";
            prefix = "${pkgs.clang}/bin";
          }
        ];
      };
    });
}


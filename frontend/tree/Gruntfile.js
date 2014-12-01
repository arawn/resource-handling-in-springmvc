module.exports = function(grunt) {
  require('time-grunt')(grunt);
  require("load-grunt-tasks")(grunt, { pattern: ["grunt-*", "assemble"] });

  var profile = grunt.option("profile", "local");
  var environment = {
    profile: profile,
    assetPath: {
      css: "/assets/css",
      js: "/assets/js",
      lib: "/libs"
    }
  };

  grunt.initConfig({
    pkg: grunt.file.readJSON("package.json"),
    jshint: {
      options: {
        jshintrc: true
      },
      assets: {
        src: "src/assets/js/**/*.js"
      }
    },
    plato: {
      options: {
        jshint: grunt.file.readJSON(".jshintrc")
      },
      scripts: {
        files: {
          "reports": ["src/assets/js/**/*.js"]
        }
      }
    },
    clean: {
      main: ["dist/", ".tmp"]
    },
    assemble: {
      options: {
        helpers: "src/helpers/helper-*.js",
        partials: "src/includes/**/*.hbs",
        layoutdir: "src/layouts",
        layout: "default.hbs",
        environment: environment
      },
      main: {
        files: [{ expand: true, cwd: "src/pages/", src: ["**/*.hbs"], dest: "dist/pages" }]
      },
      useminPrepare: {
        options: {
          layout: false
        },
        files: [{ expand: true, cwd: "src/includes/", src: ["**/*.hbs"], dest: ".tmp/assemble/useminPrepare/" }]
      }
    },
    copy: {
      img: {
        files: [{ expand: true, cwd: "src/", src: ["assets/img/**/*.*"], dest: "dist/" }]
      }
    },
    useminPrepare: {
      main: {
        src: [".tmp/assemble/useminPrepare/**/*.html"]
      }
    },
    filerev: {
      options: {
        algorithm: "md5",
        length: 8
      },
      dist: {
        src: ["dist/assets/js/**/*.js", "dist/assets/css/**/*.css"]
      }
    },
    usemin: {
      html: "dist/**/*.html",
      options: {
        assetsDirs: ["dist/"],
        blockReplacements: {
          css: function (block) {
            return "<link rel='stylesheet' type='text/css' href='" + block.dest + "'/>";
          }
        }
      }
    },
    connect: {
      main: {
        options: {
          port: 9000,
          protocol: "http",
          base: {
            path: "dist/pages/",
            options: {
              index: 'about.html'
            }
          },
          middleware: function(connect, options, middlewares) {
            middlewares.unshift(connect.static("src/"));

            return middlewares;
          }
        }
      }
    },
    watch: {
      options: {
        interrupt: true,
        livereload: true
      },
      assets: {
        files: ['src/assets/css/**/*.css', 'src/assets/js/**/*.js'],
        tasks: []
      },
      handlebars: {
        files: ['src/includes/**/*.hbs', 'src/layouts/**/*.hbs', 'src/pages/**/*.hbs'],
        tasks: ['newer:assemble']
      }
    }
  });

  grunt.registerTask("default", []);
  grunt.registerTask("platoAll", ["plato"]);

  grunt.registerTask("build:develop", ["clean", "assemble", "connect", "watch"]);
  grunt.registerTask("build:release", ["clean", "assemble", "jshint", "useminPrepare", "concat:generated", "cssmin:generated", "uglify:generated", "filerev", "usemin"]);

};

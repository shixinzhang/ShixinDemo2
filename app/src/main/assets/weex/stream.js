// { "framework": "Vue" }
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(1)
	)

	/* script */
	__vue_exports__ = __webpack_require__(2)

	/* template */
	var __vue_template__ = __webpack_require__(3)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "/Users/zhangshixin/Documents/weex/weexdemo/stream.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-714dbaa6"
	__vue_options__.style = __vue_options__.style || {}
	__vue_styles__.forEach(function (module) {
	  for (var name in module) {
	    __vue_options__.style[name] = module[name]
	  }
	})
	if (typeof __register_static_styles__ === "function") {
	  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
	}

	module.exports = __vue_exports__
	module.exports.el = 'true'
	new Vue(module.exports)


/***/ },
/* 1 */
/***/ function(module, exports) {

	module.exports = {
	  "wrapper": {
	    "justifyContent": "center",
	    "flexDirection": "column"
	  },
	  "group": {
	    "flexDirection": "row",
	    "justifyContent": "center",
	    "marginBottom": 40
	  },
	  "title": {
	    "fontSize": 45,
	    "color": "#888888"
	  },
	  "count": {
	    "fontSize": 45,
	    "fontWeight": "bold",
	    "marginLeft": 12,
	    "color": "#41B883"
	  }
	}

/***/ },
/* 2 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var stream = weex.requireModule('stream');

	exports.default = {
		data: function data() {
			return {
				weexStar: 'unknown',
				shixinStar: 'unknown'
			};
		},

		methods: {
			getStarCount: function getStarCount(repo, callback) {
				return stream.fetch({
					method: 'GET',
					type: 'json',
					url: 'https://api.github.com/repos/' + repo
				}, callback);
			}
		},
		created: function created() {
			var _this = this;

			this.getStarCount('alibaba/weex', function (res) {
				_this.weexStar = res.ok ? res.data.stargazers_count : '(network error)';
			});
			this.getStarCount('shixinzhang/DistanceMeasure', function (res) {
				_this.shixinStar = res.ok ? res.data.stargazers_count : '(network error)';
			});
		}
	};
	module.exports = exports['default'];

/***/ },
/* 3 */
/***/ function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', {
	    staticClass: ["wrapper"]
	  }, [_c('div', {
	    staticClass: ["group"]
	  }, [_c('text', {
	    staticClass: ["title"]
	  }, [_vm._v("Weex Star:")]), _c('text', {
	    staticClass: ["count"]
	  }, [_vm._v(_vm._s(_vm.weexStar))])]), _c('div', {
	    staticClass: ["group"]
	  }, [_c('text', {
	    staticClass: ["title"]
	  }, [_vm._v("Shixin Star:")]), _c('text', {
	    staticClass: ["count"]
	  }, [_vm._v(_vm._s(_vm.shixinStar))])])])
	},staticRenderFns: []}
	module.exports.render._withStripped = true

/***/ }
/******/ ]);
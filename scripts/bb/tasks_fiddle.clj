(require 'tasks)

(def list-result
  (->> {:cli     "sf"
        :command "env list"}
       (tasks/cli-response)
       (tasks/checked-result)))

(->> list-result
     :scratchOrgs
     (map :aliases))

; show default scratch org name
(->> {:cli     "sf"
      :command "config list"}
     (tasks/cli-response)
     (tasks/checked-result)
     (filter #(= "target-org" (:name %)))
     first
     :value)

; generate scratch org password
(def password-result
  (->> {:cli     "sfdx"
        :command "force:user:password:generate"
        :args {:length 12}}
       (tasks/cli-response)
       (tasks/checked-result)))

; https://developer.salesforce.com/docs/atlas.en-us.238.0.sfdx_dev.meta/sfdx_dev/sfdx_dev_unlocked_pkg_install_pkg_cli.htm
(def install-result
  (->> {:cli     "sfdx"
        :command "force:package:install"
        :args {:package "\"04t1n000002WsInAAK\""}}
       (tasks/cli-response)
       (tasks/checked-result)))
; polling loop using prev install request id
(-> {:command        (fn [_]
                       {:cli        "sfdx"
                        :command    "force:package:install:report"
                        :args       {:request-id (:Id install-result)}})
     :success?       (fn [result]
                       (= "SUCCESS" (:Status result)))
     :poll-max       5
     :sleep-duration 5}
    (tasks/poll-for-success!)
    (tasks/checked-result))


